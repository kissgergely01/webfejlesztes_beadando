import {Component, OnInit} from '@angular/core';
import {Auto, AutoService} from '../auto.service';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-auto-list',
  imports: [MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    FormsModule, NgIf],
  templateUrl: './auto-list.component.html',
  styleUrl: './auto-list.component.css'
})
export class AutoListComponent implements OnInit {
  autok: any[] = [];
  displayedColumns: string[] = ['gyarto', 'model', 'evjarat', 'ar', 'actions'];
  dataSource = new MatTableDataSource<Auto>(this.autok);

  newAuto: Auto = { gyarto: '', model: '', evjarat: 0, ar: 0 };
  isEditing = false;

  constructor(private autoService: AutoService) {}

  /*ngOnInit() {
    this.ruhaService.getAllRuha().subscribe(
      data => this.ruhak = data,
      error => console.error('Hiba történt a ruházati adatok lekérdezése során', error)
    );
  }*/
  ngOnInit() {
    this.loadAutok();
  }

  loadAutok() {
    this.autoService.getAllAuto().subscribe(data => {
      this.autok = data;
      this.dataSource.data = data;
    });
  }

  addOrUpdateAuto() {
    if (this.isEditing && this.newAuto.id) {
      // Update existing car
      this.autoService.updateAuto(this.newAuto).subscribe({
        next: (updatedAuto) => {
          // Replace the old auto in the data source
          const index = this.dataSource.data.findIndex((auto) => auto.id === updatedAuto.id);
          if (index !== -1) {
            this.dataSource.data[index] = updatedAuto;
            this.dataSource.data = [...this.dataSource.data]; // Trigger change detection
          }
          this.resetForm();
        },
        error: (err) => {
          console.error('Failed to update auto:', err);
        }
      });
    } else {
      // Add a new car
      this.autoService.saveAuto(this.newAuto).subscribe({
        next: (newAuto) => {
          this.dataSource.data = [...this.dataSource.data, newAuto]; // Add to list
          this.resetForm();
        },
        error: (err) => {
          console.error('Failed to save auto:', err);
        }
      });
    }
  }


  editAuto(auto: Auto) {
    this.newAuto = { ...auto };
    this.isEditing = true;
  }

  deleteAuto(id: number) {
    this.autoService.deleteAuto(id).subscribe(() => this.loadAutok());
  }

  resetForm() {
    this.newAuto = { gyarto: '', model: '', evjarat: 0, ar: 0 };
    this.isEditing = false;
  }
}

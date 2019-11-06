import { Component } from '@angular/core';
import axios from 'axios';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  houses = []
  error = ""

  constructor() {
    this.loadHouses();
  }


  loadHouses() {
    const that = this
    axios.get('http://localhost:8080/api/panden')
      .then(function (response) {
        that.houses = response.data;
      })
      .catch(function (error) {
        that.error = error
      });
  }
}

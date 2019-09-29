import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgForm, FormControl } from '@angular/forms';
import axios from 'axios';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';

@Component({
    selector: 'app-root',
    templateUrl: './reserveer.component.html',
    styleUrls: ['./reserveer.component.css']
})
export class ReserveerComponent implements OnInit {
    showErrorMsg = false;
    showSuccessMsg = false;
    pandId = 0;
    aantalPersonen = 1;
    datum: Date;

    constructor(private _Activatedroute: ActivatedRoute) {

    }
    ngOnInit() {
        this.pandId = this._Activatedroute.snapshot.params['id'];
        console.log(this.pandId);

    }

    public reserveer() {
        const that = this
        if (this.aantalPersonen > 1 && this.datum != null) {
            var error = false;
            axios.post(`http://localhost:8080/api/reserveer?pandId=${this.pandId}`, {
                "id": 0,
                "aantalPersonen": this.aantalPersonen,
                "eindDatum": this.datum
            })
                .then((response) => {
                    console.log(response);
                    this.showErrorMsg = false;
                    this.showSuccessMsg = true;
                })
                .catch((error) => {
                    this.showErrorMsg = true;
                    this.showSuccessMsg = false;
                    console.error(error);

                });
        }
    }
}

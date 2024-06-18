import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router'
// import { error } from 'console';


@Injectable()

export class HttpServiceService {


  token = '';
  form = {
  message: '',
  error: false
  };
 

  userparams = {
    url: '',
    sessionExpiredMsg: '',
    methodType: '',
  };


 

  constructor(private router: Router, private httpClient: HttpClient) {

  }


  get(endpoint, callback) {
   
    return this.httpClient.get(endpoint,{ withCredentials: true }).subscribe((data) => {
      console.log('Data :: ' + data);
      callback(data);

    }, error =>{
      console.log('OR|S Error--', error);
      if(error.status === 401){
        localStorage.clear();
        this.userparams.url = this.router.url;
        this.router.navigate(['/login'],{
          queryParams: {errorMessage: error.error.error},

        })
      }
    });
  }

  post(endpoint, bean, callback) {
   
    return this.httpClient.post(endpoint, bean, { withCredentials: true }).subscribe((data) => {
      console.log(data);
      callback(data);

    }, error => {
      console.log('ORS Error--', error);
      if(error.status === 401){
        localStorage.clear();
        this.router.navigate(['/login'],{
          queryParams: {errorMessage: error.error.error},
        })
      }
    });
  }


}



import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http";
import { Observable } from "rxjs";

export class AppHttpInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
        req= req.clone({
            headers: req.headers.set('Authorization', 'Basic ' + sessionStorage.getItem('token'))
        });
        return next.handle(req);
        
    }

    
}
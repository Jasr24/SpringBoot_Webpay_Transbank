package js.andres.controladores;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import js.andres.modelos.CrearTokenModel;
import js.andres.modelos.RequestModel;
import js.andres.modelos.RespuestaVerificacionModel;
import js.andres.utilidades.Constantes;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/")
public class homeController {
    
    @GetMapping("")
    public String home(){
        return "home/home";
    }

    @GetMapping("/pagar")
    public String pagar(Model model){
        
        //Desacoplar esto... en este ejemplo todo estara aqui.
        
        RestTemplate restTemplate = new RestTemplate();

        //Configurando los cabeceros
        HttpHeaders headers = new HttpHeaders();
		headers.set("Tbk-Api-Key-Id", Constantes.WEBPAY_CODIGO_COMERCIO);
		headers.set("Tbk-Api-Key-Secret", Constantes.WEBPAY_CODIGO_SECRETO);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        //Generamos la peticion
        RequestModel post =new RequestModel("ordenCompra12rrdd", "sesion1234557545", 10000, "http://localhost:8006/respuesta");
        //Construimos el json request
        //Asi pasamos los parametros como un jsonRequest.
        HttpEntity<RequestModel> request = new HttpEntity<>(post, headers);
        //enviamos la peticion post
        ResponseEntity<CrearTokenModel> response = restTemplate.postForEntity(Constantes.WEBPAY_URL, request, CrearTokenModel.class);
        
        model.addAttribute("response", response.getBody());

        return "home/pagar";
    }

    @GetMapping("/respuesta")
	public String respuesta(Model model, @RequestParam("token_ws") String token_ws) /*token_ws TIENE QUE LLAMARSE ASI */
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Tbk-Api-Key-Id", Constantes.WEBPAY_CODIGO_COMERCIO);
		headers.set("Tbk-Api-Key-Secret", Constantes.WEBPAY_CODIGO_SECRETO);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<RespuestaVerificacionModel> response = restTemplate.exchange(Constantes.WEBPAY_URL+"/"+token_ws, HttpMethod.PUT, entity, RespuestaVerificacionModel.class);
		
		RespuestaVerificacionModel respuesta = response.getBody();
		model.addAttribute("respuesta", respuesta);
		model.addAttribute("token_ws", token_ws);
		return "home/respuesta";
	}

}

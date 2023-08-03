package com.projeto.teste.controller;


import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/principal")
public class PrincipalController {

    @GetMapping("/{param}")
    public ResponseEntity<List<Object>> principal(@PathVariable String param){

        return ResponseEntity.ok(consumeAPI(param));
    }


    private List<Object> consumeAPI(String param) throws URISyntaxException {
        List<Object> listaDeItensDaAPI = new ArrayList<>();
//        try {
//
//            URL url = new URL("https://viacep.com.br/ws/" + param + "/json/");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP Error code : "
//                        + conn.getResponseCode());
//            }
//            InputStreamReader in = new InputStreamReader(conn.getInputStream());
//            BufferedReader br = new BufferedReader(in);
//            String output;
//            while ((output = br.readLine()) != null) {
//                listaDeItensDaAPI.add(output);
//            }
//            conn.disconnect();
//
//        } catch (Exception e) {
//            System.out.println("Exception in NetClientGet:- " + e);
//        }

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://viacep.com.br/ws/" + param + "/json/")).GET().build();

        return listaDeItensDaAPI;
    }
}

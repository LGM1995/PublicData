package com.lgm.publicdata.controller;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {
    //버스 노선 조회용 키 (버스 번호를 확인하기 위함) [경기도_버스노선 조회]
    private final String key1
            = "8nVvnCaHdPMQ1FyiBt%2FGDPqoVvFrRLfmbD42Cw9IGEN%2By7ZEaAYEvklEovHXVs5ac7V8IuvU7LWPUUoh4DtFRQ%3D%3D";
//            = "8nVvnCaHdPMQ1FyiBt/GDPqoVvFrRLfmbD42Cw9IGEN+y7ZEaAYEvklEovHXVs5ac7V8IuvU7LWPUUoh4DtFRQ==";
    //버스 도착 정보 조회용 키 (정류소에 도착예정 버스 정보를 확인하기 위함) [경기도_버스도착정보 조회]
    private final String key2
            = "8nVvnCaHdPMQ1FyiBt%2FGDPqoVvFrRLfmbD42Cw9IGEN%2By7ZEaAYEvklEovHXVs5ac7V8IuvU7LWPUUoh4DtFRQ%3D%3D";
    // 버스 정류소 조회용 키 (정류소 ID를 확인하기 위함) [경기도_정류소 조회]
    private final String key3
            = "8nVvnCaHdPMQ1FyiBt%2FGDPqoVvFrRLfmbD42Cw9IGEN%2By7ZEaAYEvklEovHXVs5ac7V8IuvU7LWPUUoh4DtFRQ%3D%3D";

    // 버스 노선 조회 url
    private final String baseUrl1
            = "http://apis.data.go.kr/6410000/busrouteservice";
    // 버스 도착 정보 url
    private final String baseUrl2
            = "http://apis.data.go.kr/6410000/busarrivalservice";
    // 버스 정류소 조회 url
    private final String baseUrl3
            = "http://apis.data.go.kr/6410000/busstationservice";

    @GetMapping("/ip")
    public ResponseEntity<String> getClientIp(HttpServletRequest req) {
        return ResponseEntity.ok(req.getRemoteAddr());
    }

    @GetMapping("/public")
    public ResponseEntity<String> getPublic(HttpServletRequest req) throws IOException, URISyntaxException {
        URI uri = new URI("http://apis.data.go.kr/6410000/busrouteservice/getBusRouteInfoItem?serviceKey=" + key1 + "&routeId=229000028");

        // Spring에서 Rest 방식 API를 호출할 수 있는 내장 클래스
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        // response body에 담겨있는 xml을 json화
        JSONObject json = XML.toJSONObject(response.getBody().toString());
        // 행간 거리 2칸
        System.out.println(json.toString(2));

        return response;
    }

}

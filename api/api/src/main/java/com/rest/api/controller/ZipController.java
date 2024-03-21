package com.rest.api.controller;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@RestController(value = "/zip")
public class ZipController {

    @PostMapping(value = "/ZipFile", produces="application/zip")
    public void getZipFile(){
        HttpResponse<File> response = Unirest.post("https://www.correosdemexico.gob.mx/SSLServicios/ConsultaCP/CodigoPostal_Exportar.aspx")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Accept-Language", "es-ES,es;q=0.9")
                .header("Cache-Control", "max-age=0")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Origin", "https://www.correosdemexico.gob.mx")
                .header("Referer", "https://www.correosdemexico.gob.mx/SSLServicios/ConsultaCP/CodigoPostal_Exportar.aspx")
                .header("Sec-Fetch-Dest", "document")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-User", "?1")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Windows\"")
                .field("__EVENTTARGET", "")
                .field("__EVENTARGUMENT", "")
                .field("__LASTFOCUS", "")
                .field("__VIEWSTATE", "/wEPDwUINzcwOTQyOTgPZBYCAgEPZBYCAgEPZBYGAgMPDxYCHgRUZXh0BTzDmmx0aW1hIEFjdHVhbGl6YWNpw7NuIGRlIEluZm9ybWFjacOzbjogTm92aWVtYnJlIDI0IGRlIDIwMjJkZAIHDxAPFgYeDURhdGFUZXh0RmllbGQFA0Vkbx4ORGF0YVZhbHVlRmllbGQFBUlkRWRvHgtfIURhdGFCb3VuZGdkEBUhIy0tLS0tLS0tLS0gVCAgbyAgZCAgbyAgcyAtLS0tLS0tLS0tDkFndWFzY2FsaWVudGVzD0JhamEgQ2FsaWZvcm5pYRNCYWphIENhbGlmb3JuaWEgU3VyCENhbXBlY2hlFENvYWh1aWxhIGRlIFphcmFnb3phBkNvbGltYQdDaGlhcGFzCUNoaWh1YWh1YRFDaXVkYWQgZGUgTcOpeGljbwdEdXJhbmdvCkd1YW5hanVhdG8IR3VlcnJlcm8HSGlkYWxnbwdKYWxpc2NvB03DqXhpY28UTWljaG9hY8OhbiBkZSBPY2FtcG8HTW9yZWxvcwdOYXlhcml0C051ZXZvIExlw7NuBk9heGFjYQZQdWVibGEKUXVlcsOpdGFybwxRdWludGFuYSBSb28QU2FuIEx1aXMgUG90b3PDrQdTaW5hbG9hBlNvbm9yYQdUYWJhc2NvClRhbWF1bGlwYXMIVGxheGNhbGEfVmVyYWNydXogZGUgSWduYWNpbyBkZSBsYSBMbGF2ZQhZdWNhdMOhbglaYWNhdGVjYXMVIQIwMAIwMQIwMgIwMwIwNAIwNQIwNgIwNwIwOAIwOQIxMAIxMQIxMgIxMwIxNAIxNQIxNgIxNwIxOAIxOQIyMAIyMQIyMgIyMwIyNAIyNQIyNgIyNwIyOAIyOQIzMAIzMQIzMhQrAyFnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dkZAIdDzwrAAsAZBgBBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WAQULYnRuRGVzY2FyZ2EP0jYcnu+YNsd5N4Ocg4gaMLUZvw==")
                .field("__VIEWSTATEGENERATOR", "BE1A6D2E")
                .field("__EVENTVALIDATION", "/wEWKAKEkrW/DgLG/OLvBgLWk4iCCgLWk4SCCgLWk4CCCgLWk7yCCgLWk7iCCgLWk7SCCgLWk7CCCgLWk6yCCgLWk+iBCgLWk+SBCgLJk4iCCgLJk4SCCgLJk4CCCgLJk7yCCgLJk7iCCgLJk7SCCgLJk7CCCgLJk6yCCgLJk+iBCgLJk+SBCgLIk4iCCgLIk4SCCgLIk4CCCgLIk7yCCgLIk7iCCgLIk7SCCgLIk7CCCgLIk6yCCgLIk+iBCgLIk+SBCgLLk4iCCgLLk4SCCgLLk4CCCgLL+uTWBALa4Za4AgK+qOyRAQLI56b6CwL1/KjtBSZC6JwAi00FNxZZ8CX7Tu0TiCUO")
                .field("cboEdo", "00")
                .field("rblTipo", "txt")
                .field("btnDescarga.x", "19")
                .field("btnDescarga.y", "6")
                .asFile("C:\\Users\\ivanc\\Documents\\Ivan\\ExtraCode\\test.zip");
                System.out.println("Writting File");
                System.out.println(response);
    }

    @PostMapping(value = "/unzip")
    public void unzipFile(){
        this.unzip("C:\\Users\\ivanc\\Documents\\Ivan\\ExtraCode\\test.zip","C:\\Users\\ivanc\\Documents\\Ivan\\ExtraCode");
    }

    public void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

//package org.momo.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//
//import java.util.Arrays;
//
//@Configuration
//public class MultipartConfig {
//    @Bean
//    public MultipartJackson2HttpMessageConverter multipartJackson2HttpMessageConverter() {
//        MultipartJackson2HttpMessageConverter converter = new MultipartJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Arrays.asList(
//                MediaType.MULTIPART_FORM_DATA,
//                MediaType.APPLICATION_OCTET_STREAM
//        ));
//        return converter;
//    }
//}
//

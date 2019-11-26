package com.fff.solr_springboot;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SolrSpringbootApplicationTests {

    @Test
    public void testAdd() {
        String solrURL = "http://localhost:8081/solr/index.html#/";
//        单机版
        SolrServer solrServer = new HttpSolrServer(solrURL);



    }

    @Test
    public void testShiro(){
        String USERNAME = "admin";
        String PASSWORD = "1";
        String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString();
        System.out.println(passwd);
    }

}

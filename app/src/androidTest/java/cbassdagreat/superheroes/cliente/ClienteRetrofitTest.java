package cbassdagreat.superheroes.cliente;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import cbassdagreat.superheroes.LectorJson;
import cbassdagreat.superheroes.modelo.SuperHeroe;
import cbassdagreat.superheroes.modelo.SuperHeroes;
import cbassdagreat.superheroes.service.SHService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(AndroidJUnit4.class)
public class ClienteRetrofitTest {
    private MockWebServer server;
    private String url = "http://localhost:8080/api/";
    private String body = LectorJson.lector("superHeroes.json");

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start(8080);
        server.enqueue(new MockResponse().setResponseCode(200).setBody("body"));
        server.url("id/1.json");

    }

    @After
    public void tearDown() throws Exception
    {
        server.shutdown();
    }

    @Test
    public void test_apiSuccess(){
        SHService service = ClienteRetrofit.getInstance(url);
        try {
            List<SuperHeroe> sh = service.getSuperHeroes().execute().body();
            Truth.assertThat(sh.size()).isEqualTo(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
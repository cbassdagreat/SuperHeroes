package cbassdagreat.superheroes.viewmodel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import static java.sql.DriverManager.println;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import cbassdagreat.superheroes.modelo.SuperHeroe;
import cbassdagreat.superheroes.modelo.SuperHeroes;

@RunWith(MockitoJUnitRunner.class)
public class HeroeVMTest {

    private HeroeVM viewModel;


    @Before
    public void setUp() throws Exception {
        viewModel = new HeroeVM();
    }

    @Test
    public void test_llamar_api() throws InterruptedException {
        viewModel.llamarApi();
        Thread.sleep(3000);
        SuperHeroe sh = viewModel.getMiSuperHeroe().getValue();
        verify()


    }
}
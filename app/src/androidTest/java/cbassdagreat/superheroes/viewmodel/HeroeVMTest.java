package cbassdagreat.superheroes.viewmodel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import static java.sql.DriverManager.println;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.List;

import cbassdagreat.superheroes.modelo.SuperHeroe;
import cbassdagreat.superheroes.modelo.SuperHeroes;

@RunWith(MockitoJUnitRunner.class)
public class HeroeVMTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Observer<SuperHeroe> superHeroeObserver;
    @Mock
    private Observer<List<SuperHeroe>> superHeroesObserver;
    private HeroeVM viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        viewModel = new HeroeVM();
        viewModel.getMiSuperHeroe().observeForever(superHeroeObserver);
        viewModel.getMiSuperHeroes().observeForever(superHeroesObserver);

    }

    @Test
    public void test_llamar_api() throws InterruptedException {
        viewModel.llamarApi();
        Thread.sleep(3000);
        SuperHeroe sh = viewModel.getMiSuperHeroe().getValue();
        verify(superHeroesObserver).onChanged(viewModel.getMiSuperHeroes().getValue());
    }

    @Test
    public void test_obtener_heroe() throws InterruptedException{
        viewModel.llamarApi();
        Thread.sleep(1000);
        List<SuperHeroe> sh = viewModel.getMiSuperHeroes().getValue();
        viewModel.obtenerSuperHeroe(sh.get(0));


    }
}
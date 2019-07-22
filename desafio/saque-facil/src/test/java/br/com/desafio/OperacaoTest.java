package br.com.desafio;
import static org.mockito.Mockito.verify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class OperacaoTest {

	private static final Logger logger = LoggerFactory.getLogger(OperacaoTest.class);
	
	@InjectMocks
	@Spy
	Operacao operacao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
        logger.info("============ START UNIT TEST ==============");
    }
 
	@AfterClass
    public static void tearDownAfterClass() throws Exception {
        logger.info("============ END UNIT TEST ==============");
    }

	@Test
	public void calculaNumeroValido() {
		operacao.calcular(1500.0);
		verify(operacao).calcular(1500.0);
	}
	
	@Test
	public void calculaNumeroNaoValido() {
		operacao.calcular(155.0);
		verify(operacao).calcular(155.0);
	}
	
	@Test
	public void calculaNumeroNulo() {
		operacao.calcular(0);
		verify(operacao).calcular(0);
	}
}

package teste;

import negocio.Pais;
import service.PaisService;

import org.junit.runners.MethodSorters;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Teste {

	private Pais pais,copia;
	private PaisService service;
	static int id = 1;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Setup");
		pais = new Pais(id,"paisae",82521700,357051);
		copia = new Pais(id,"Alemanha",82521700,357051);
		service = new PaisService();
		System.out.println(pais.toString());
	}
	
	@Test
	public void teste1() {
		System.out.println("Criando");
		service.criar(pais);
		id = pais.getId();
		assertEquals(pais.getId(),copia.getId(),"Teste de criacao");
		
	}
	

	
	@Test
	public void teste2() {
		System.out.println("Atualizar");

		pais.setNome("Atualizado");
		copia.setNome("Atualizado");
		
		service.alterarNome(pais, "Nome");
		service.selectPais(pais);
		
		assertEquals(pais.getNome(),copia.getNome(),"Testando atualizacao");
		System.out.println(pais.toString());
	}
	
	public void teste3() {
		
		System.out.println("Teste Carregar");
		service.selectPais(pais);
		assertEquals(pais.getId(),copia.getId(),"Testando criacao");
	}
	
	@Test
	public void teste4() {
		System.out.println("Excluir Pais");
		service.deletar(pais);
		copia.setId(-1);
		
		service.selectPais(pais);
		assertEquals(pais.getId(),copia.getId(),"Teste de criacao");
	}

	@Test
	public void teste5() {
		System.out.println("Maior populacao");
		service.habitantes(pais);
		
		long pop = pais.getPopulacao();
		copia.setPopulacao(pop);
		assertEquals(pais.getPopulacao(),copia.getPopulacao(),"Testando maior populacao");
		System.out.println(pais.toString());
	}
	
	@Test
	public void teste6() {
		System.out.println("Menor Area");
		service.menorArea(pais);
		double area = pais.getArea();		
		copia.setArea(area);
		System.out.println(pais.toString());

		assertEquals(pais.getArea(),copia.getArea(),"Testando menor area");
	}
	
	@Test
	public void teste7() {
		System.out.println("Vetor de paises");
		String[] array = service.arrayPais();
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		assertEquals(array.length,3,"Testando Vetor de paises");
	}
	
	
}

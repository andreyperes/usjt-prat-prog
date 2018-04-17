package service;
	
	import negocio.Pais;
	import dao.PaisDAO;

	public class PaisService {
		PaisDAO dao;
		
		public PaisService() {
			 dao = new PaisDAO();
		}
		
		public void criar(Pais pais) {
			dao.IncluirPais(pais);
		}
		
		public void alterarNome(Pais pais, String nome) {
			dao.AtualizarPais(pais, nome);
		}
		
		public void deletar(Pais pais) {
			dao.DeletarPais(pais);
		}
		
		public void selectPais(Pais pais) {
			dao.CarregarPais(pais);
		}
		
		public void menorArea(Pais pais){
			dao.getMenorArea(pais);
		}
		
		public void habitantes(Pais pais){
			dao.getHabitantes(pais);
		}
		
		public String[] arrayPais() {
			return dao.vetorPais();
		}
	}


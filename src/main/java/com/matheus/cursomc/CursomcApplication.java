package com.matheus.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.cursomc.domain.Categoria;
import com.matheus.cursomc.domain.Cidade;
import com.matheus.cursomc.domain.Cliente;
import com.matheus.cursomc.domain.Endereco;
import com.matheus.cursomc.domain.Estado;
import com.matheus.cursomc.domain.Produto;
import com.matheus.cursomc.domain.enums.TipoCliente;
import com.matheus.cursomc.repositories.CategoriaRepository;
import com.matheus.cursomc.repositories.CidadeRepository;
import com.matheus.cursomc.repositories.ClienteRepository;
import com.matheus.cursomc.repositories.EnderecoRepository;
import com.matheus.cursomc.repositories.EstadoRepository;
import com.matheus.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cit1 = new Cidade(null, "Uberlândia", est1);
		Cidade cit2 = new Cidade(null, "São Paulo", est2);
		Cidade cit3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cit1));
		est2.getCidades().addAll(Arrays.asList(cit2, cit3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
		
		Cliente cli1 = new Cliente(null, "Matheus Ferro", "matheus@gmail.com", "478654", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("123456", "7654321"));
		
		Endereco e1 = new Endereco(null, "Rua Fernao Marques", "93", "Casa", "Vila Prudente", "0333", cli1, cit1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Apto", "Centro", "5235", cli1, cit2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}

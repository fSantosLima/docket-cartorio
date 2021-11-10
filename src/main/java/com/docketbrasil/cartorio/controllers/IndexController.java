package com.docketbrasil.cartorio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docketbrasil.cartorio.entities.Cartorio;
import com.docketbrasil.cartorio.entities.TipoCertidao;
import com.docketbrasil.cartorio.service.CartorioService;
import com.docketbrasil.cartorio.service.TipoCertidaoService;

@Controller
@RequestMapping("/home/")
public class IndexController {

	@Autowired
	private CartorioService cartorioService;

	@Autowired
	private TipoCertidaoService certidaoService;

	@Value("${certidoes.api.endpoint}")
	private String baseEndpoint;

	@GetMapping(value = "index")
	public String index(Model model, Cartorio cartorio) {
		try {
			popularListaDeCertidoes();
			model.addAttribute("cartorios", cartorioService.findAll());
			model.addAttribute("certidoes", certidaoService.findAll());

		} catch (Exception e) {
			return "paginaErro";
		}
		return "cartorio";
	}

	@PostMapping(value = "save")
	public String salvarCartorio(@Validated Cartorio cartorio, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Ocorreu um erro ao realizar a operação.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}

		try {
			Optional<Cartorio> cartorioSalvo = cartorioService.findById(cartorio.getId());

			if (cartorioSalvo.isPresent()) {
				cartorio.setId(cartorioSalvo.get().getId());
				cartorioService.save(cartorio);
				redirectAttributes.addFlashAttribute("message", "Registro alterado com sucesso.");
			} else {
				cartorioService.save(cartorio);
				redirectAttributes.addFlashAttribute("message", "Cadastro realizado com sucesso.");
			}
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Ocorreu um erro ao realizar a operação.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}

		return "redirect:index";
	}

	@GetMapping(value = "delete/{id}")
	public String deletarCartorio(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {

		try {
			Cartorio cartorio = cartorioService.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
			cartorioService.delete(cartorio);
			redirectAttributes.addFlashAttribute("message", "Registro deletado com sucesso.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Ocorreu um erro ao realizar a operação.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}
		return "redirect:/home/index";
	}

	@GetMapping(value = "edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Cartorio cartorio = cartorioService.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		model.addAttribute("cartorio", cartorio);
		model.addAttribute("certidoes", certidaoService.findAll());

		return "editarCartorio";
	}
	
	/**
	 * Método responsável por consumir a api da Docket e retornar os tipos de certidões existentes para cadastro.
	 * @return Lista de certidoes que serão inseridas na base h2
	 * 
	 * @author Fernando Santos de Lima
	 */
	public void popularListaDeCertidoes() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TipoCertidao[]> responseEntity = restTemplate.getForEntity(baseEndpoint, TipoCertidao[].class);
		for (TipoCertidao certidao : responseEntity.getBody()) {
			certidaoService.save(certidao);
		}
	}

}

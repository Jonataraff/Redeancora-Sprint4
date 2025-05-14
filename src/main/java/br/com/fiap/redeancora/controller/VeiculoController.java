package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Cliente;
import br.com.fiap.redeancora.model.Veiculo;
import br.com.fiap.redeancora.repository.VeiculoRepository;
import br.com.fiap.redeancora.repository.ClienteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "clientes/menu/cadastro-veiculos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Veiculo veiculo, HttpSession session) {
        // Debug: exibe o conteúdo vindo do formulário
        System.out.println(">>> Dados recebidos do formulário:");
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Ano: " + veiculo.getAno());

        Cliente clienteLogado = (Cliente) session.getAttribute("clienteLogado");

        if (clienteLogado != null) {
            veiculo.setCliente(clienteLogado);
            veiculoRepo.save(veiculo);
            return "clientes/menu/cadastrado-com-sucesso";
        } else {
            return "redirect:/login/cliente";
        }
    }
    @GetMapping("/listar")
    public String listarTodos(Model model) {
        model.addAttribute("veiculos", veiculoRepo.findAll());
        return "clientes/menu/lista-veiculo";
    }
}
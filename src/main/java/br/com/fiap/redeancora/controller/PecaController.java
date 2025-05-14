package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Peca;
import br.com.fiap.redeancora.service.PecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pecas")
public class PecaController {

    private final PecaService service;

    public PecaController(PecaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(name = "nome", required = false) String nome, Model model) {
        List<Peca> pecas = (nome == null || nome.isBlank())
                ? service.listarTodos()
                : service.buscarPorNome(nome);

        model.addAttribute("pecas", pecas);
        return "clientes/menu/lista-peca";
    }

    @GetMapping("/cadastrar")
    public String cadastrarForm(Model model) {
        model.addAttribute("peca", new Peca());
        return "clientes/menu/cadastro-pecas";
    }

    @PostMapping("/cadastrar")
    public String salvarPeca(@ModelAttribute Peca peca) {
        service.salvar(peca);
        return "redirect:/pecas";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Peca buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
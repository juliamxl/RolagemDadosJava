package com.example.dado.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Dado {

    @GetMapping("/")
    public String main() {
        return "Main/mainDado";
    }

    @PostMapping("/")
    public String processarDadosDoFormulario(@RequestParam("Faces") int faces,
                                             @RequestParam("Quantidade") int quantidade,
                                             Model model) {

        Random random = new Random();
        List<ResultadoDado> resultados = new ArrayList<>();

        int maiorNumero = 0;
        int somaNumeros = 0;

        for (int i = 0; i < quantidade; i++) {
            int rolagemFaces = random.nextInt(faces) + 1;
            somaNumeros += rolagemFaces;
            if (maiorNumero < rolagemFaces){
                maiorNumero = rolagemFaces;
            }
            resultados.add(new ResultadoDado(i + 1, rolagemFaces));
        }

        model.addAttribute("resultados", resultados);
        model.addAttribute("maiorNumero", maiorNumero);
        model.addAttribute("somaNumeros", somaNumeros);


        return "Main/mainDado"; // Retornar a visualização onde você deseja exibir a tabela
    }

    public class ResultadoDado {
        private int id;
        private int resultado;

        public ResultadoDado(int id, int resultado) {
            this.id = id;
            this.resultado = resultado;
        }

        public int getId() {
            return id;
        }

        public int getResultado() {
            return resultado;
        }
    }
}
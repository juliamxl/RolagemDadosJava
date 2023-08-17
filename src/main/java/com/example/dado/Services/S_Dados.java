package com.example.dado.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class S_Dados {
    public List<ResultadoDado> realizarJogada(int quantidadeDados, int facesDado) {
        Random random = new Random();
        List<ResultadoDado> resultados = new ArrayList<>();
        int maiorNumero = 0;
        int somaNumeros = 0;

        for (int i = 0; i < quantidadeDados; i++) {
            int rolagemFaces = random.nextInt(facesDado) + 1;
            somaNumeros += rolagemFaces;

            resultados.add(new ResultadoDado(i + 1, rolagemFaces));
        }

        return resultados;
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

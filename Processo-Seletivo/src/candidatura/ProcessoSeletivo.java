package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ProcessoSeletivo
 */
public class ProcessoSeletivo {

    public static void main(String[] args) {
        analisarCandidato(1800);
        System.out.println();
        analisarCandidato(2000);
        System.out.println();
        analisarCandidato(2100);
        System.out.println();
        selecaoCandidato();
        System.out.println();
        imprimirCandidatos();
        System.out.println();
        String[] candidatos = {"victor", "henrique", "oliveira", "lima", "amanda"};
        for (String candidato : candidatos) {
            ligacaoCandidato(candidato);
            System.out.println();
        }

    }
    
    static void ligacaoCandidato(String candidato){
        int tentativaRealizada = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativaRealizada++;
            }else{
                System.out.println("Contato realizado");
            }
        } while (continuarTentando && tentativaRealizada < 3);
        if(atendeu){
            System.out.println("Conseguimos contato " + candidato + " , numero maximo de tentativas "
            + tentativaRealizada + " Realizadas");
        }else{
            System.out.println("Não conseguimos contato com " + candidato + " , numero maximo de tentativas " 
            + tentativaRealizada + " Realizadas");
        }
    }   

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirCandidatos(){
        String[] candidatos = {"victor", "henrique", "oliveira", "lima", "amanda"};
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("A lista de candidatos " + (i+1) + " e " + candidatos[i]);
        }
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi: " + candidato);
            
        }
    }
    
    static void selecaoCandidato(){
        String[] candidatos = {"victor", "henrique", "oliveira", "lima","amanda","pedro", 
        "claudio", "joão"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretentido();
            System.out.println("O candidato " + candidato + " Solocitou este valor de salario " 
            + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato "+ candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }

    }
    static double valorPretentido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato( double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
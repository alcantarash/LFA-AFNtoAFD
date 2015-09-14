/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformafn;

import java.util.ArrayList;

/**
 *
 * @author sheldon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arquivo arq = new Arquivo("file1.afnd");;
        String Estado;
        String Alfabeto;
        ArrayList<String> Transicao = new ArrayList<>();
        String prox = arq.proximaPalavra();
        AutomataFND afnd = new AutomataFND(); 

        while (!prox.equals("EOF")) {
            if (prox.charAt(0) == 'E') {
                Estado = prox.replaceAll(" ", "").replaceAll(":", "").replaceAll(",", "").replaceAll("\\.", "");
                System.out.println(Estado);

                for (int i = 1; i < Estado.length(); i++) {
                        System.out.println(Estado.charAt(i));
                        afnd.addState("" + Estado.charAt(i));
                }
            } /*else if (prox.charAt(0) == 'A') {
                Alfabeto = prox.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(":", "").replaceAll(",", "");
                System.out.println(Alfabeto.replaceAll(".", ""));
                for (int i = 1; i < Alfabeto.length(); i++) {
                    if (Alfabeto.charAt(i) != '.') {
                        System.out.println(Alfabeto.charAt(i));
                        
                    }
                }
            }*/ else if (prox.charAt(0) == 'T') {
             while (!prox.contains("I")) {
             Transicao.add(prox.trim().replaceAll(" ", "").replaceAll(":", "").replaceAll("=", "").replaceAll(",", "").replaceAll("}", "").replaceAll("\\{", "").replaceAll("]", "").replaceAll("\\[", "").replaceAll("\\.", ""));
             prox = arq.proximaPalavra();
             }
             for (int i = 1; i < Transicao.size(); i++) {
                 
             for (int j = 2; j < Transicao.get(i).length(); j++) {
             //afd.accTransicao("" + Transicao.get(i).charAt(0), "" + Transicao.get(i).charAt(j), "" + Alfabeto.charAt(j + 1));
               afnd.addTransition("" + Transicao.get(i).charAt(0), "" + Transicao.get(i).charAt(j), "" + Transicao.get(i).charAt(1));
                 //System.out.println(Transicao.get(i).charAt(0) +"->"+ Transicao.get(i).charAt(j) +"lendo:"+ Transicao.get(i).charAt(1));
             }
             }

             } else if (prox.charAt(0) == 'I') {//Estado Inicial
             EstadoInicial = prox.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(":", "").replaceAll(",", "");
             for (int i = 2; i < EstadoInicial.length(); i++) {
             afd.seteInicial("" + EstadoInicial.charAt(i));
             }
             } else if (prox.charAt(0) == 'F') {//Estado Final
             EstadoFinal = prox.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(":", "").replaceAll(",", "");
             for (int i = 2; i < EstadoFinal.length(); i++) {
             afd.seteFinal("" + EstadoFinal.charAt(i));
             }
             }

            prox = arq.proximaPalavra();
        }
    }

}

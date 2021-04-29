package models.factories;

import java.util.ArrayList;
import java.util.Collections;

import models.Baralho;
import models.Carta;

public class BaralhoFactory {
  private final String[] naipes = {"espadas", "copas", "paus", "ouros"};
  private final String[] simbolos = {"♠", "♣", "♥", "♦"};
  private final String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  private final int[] pesos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  private int quantidadeDeBaralhos = 1;
  private Baralho baralho;
  
  public BaralhoFactory(){}
  
  public BaralhoFactory(int quantidadeDeBaralhos) {
    this.quantidadeDeBaralhos = quantidadeDeBaralhos;
  }
  
  public Baralho gerarBaralho(boolean embaralhado){
    ArrayList<Carta> cartas = new ArrayList<Carta>();

    for(int i = 0; i < quantidadeDeBaralhos; i++){
        for(int j = 0; j < naipes.length; j++){
          String naipe = naipes[j];
          String simbolo = simbolos[j];
        

          String cor = "preto";
          String ansiCor = "\u001B[37m";

          if(naipe.equals("paus") || naipe.equals("ouros")){
            cor = "vermelho";
            ansiCor = "\u001B[31m";
           }

          String ansiReset = "\u001B[0m";

          for(int k = 0; k < valores.length; k++){
            String valor = valores[k];
            int peso = pesos[k];
            
            String[] ansiTerminalColor = {ansiCor , ansiReset};

            cartas.add(new Carta(naipe, valor, simbolo, cor, ansiTerminalColor,peso));

          }
        }
    }

    if(embaralhado){
      Collections.shuffle(cartas);
    }
    
    this.baralho = new Baralho(cartas);

    return baralho;
  }

  public Baralho getBaralho() {
    return baralho;
  }  
}

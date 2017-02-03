/* Pretende-se a construção de uma classe ChristmasCircus para gerir os bilhetes de um circo de Natal. 
O circo de Natal tem lotação ilimitada. É sempre possível comprar bilhetes para o circo de Natal, 
consultar o número de bilhetes vendidos e o dinheiro em caixa. O preço do bilhete pode ser reduzido
à medida que se aproxima o Natal, no entanto o número de vezes que se reduz o preço é limitado.
Quando se cria o circo de Natal pode-se indicar o preço máximo do bilhete (em Euros) e o número 
de vezes que é possível reduzir o preço. Quando não se indica nada, o circo de Natal é criado com o 
preço de bilhete  de 10 Euros e com o número de reduções do bilhete a zero, ou seja não se pode 
reduzir o preço do bilhete.
*/

public class ChristmasCircus {
        /* Constantes */  
	public static final float PRICE_REDUCTION = 0.5f;
	public static final float DEFAULT_TICKET_PRICE = 10.0f;
	public static final int DEFAULT_REDUC_MAX = 0;

	
        /* Variáveis de Instância */ 
	private float ticketPrice;
	private int maxRed;
	
	private int numTimesReduced;
	
	private float moneyInRegister;
	private int numTicketsSold;

/* Construtor
 * @param ticketPrice: preço do bilhete em euros
 * @param maxRed: número de vezes que se pode reduzir o preço do bilhete
 * @pre ticketPrice > 0 && maxRed >= 0
 */
        public ChristmasCircus(float ticketPrice, int maxRed){            
        	this.ticketPrice = ticketPrice;
        	this.maxRed = maxRed;
        	resetVars();
        }

/* Construtor que coloca o preço do bilhete em 10 Euros e não permite redução de preço
*/
        public ChristmasCircus(){                
        	this.ticketPrice = DEFAULT_TICKET_PRICE;
            this.maxRed = DEFAULT_REDUC_MAX;
            resetVars();
        }
          
          /*
           * Metodo que efetua a venda de bilhetes.
           * @return o valor da venda.
           */
        public float buyTickets(int numBilhetes){
        	  numTicketsSold += numBilhetes;
        	  if(isPossibleReduzPrice()){
        		  ticketPrice = ticketPrice * PRICE_REDUCTION;
        		  numTimesReduced++;
        	  }
        	  moneyInRegister += numBilhetes * ticketPrice;
        	  return (numBilhetes * ticketPrice);
         }

/*
  * Consulta o nummero de tickets vendidos ate ao momento
  * @return numero de tickets vendidos
  */
        public int numberOfTickets(){
        	return numTicketsSold;
       }           

/*
  * Consulta o valor em Euros na caixa
  * @return valor em Euros
  */
        public float moneyInCash(){
        	return moneyInRegister;
       }           
        
      //Metodo auxiliar
        private void resetVars(){
        	numTimesReduced = 0;
        	moneyInRegister = 0;
        	numTicketsSold = 0;
        }
        	
        /*
         * @return devolve verdadeiro se for possivel reduzir o preco.
         */
        private boolean isPossibleReduzPrice(){          
        	return maxRed > numTimesReduced;
         }  
}      
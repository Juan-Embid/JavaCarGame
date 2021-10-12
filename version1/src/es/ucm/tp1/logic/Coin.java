package es.ucm.tp1.logic;

public class Coin {
private int x, y, cont;
Player player;

public void reset(){
	cont = 0; } //Pone a cero las coins que se ha llevado el jugador

public void gameCoinsCount() {
	cont++;}

public String toString() {
	return "¢";}

//public void receiveCollision(player) {}
}



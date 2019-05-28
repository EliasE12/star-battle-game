package model;

import java.util.Date;

// Clase

/**
 * Entidad que representa el historial de partidas del jugador.
 */
public class Record {

	// Atributos

	/**
	 * Es el siguiente historial de partidas.
	 */
	private Record next;

	/**
	 * Es la fecha de la partida.
	 */
	private String date;

	/**
	 * Es el puntaje obtenido en la partida.
	 */
	private int score;

	/**
	 * Indica si la partida fue ganada o no.
	 */
	private boolean won;

	/**
	 * Es tiempo de duración de la partida.
	 */
	private String time;


	// Constructor

	/**
	 * Inicializa los atributos de la clase  reord.
	 * @param date - La fecha de la partida.
	 * @param score - El puntaje de la partida.
	 * @param won - Indica si ha sido ganada o no.
	 * @param time - El tiempo de duracion de la partida.

	 */
	public Record(String date, int score, boolean won, String time) {
		this.date = date;
		this.score = score;
		this.won = won;
		this.time = time;

		next = null;
	}

	// Métodos


	public Record getNext() {
		return next;
	}

	/**
	 * Devuelve la fecha de la partida.
	 * @return date.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Devuelve el puntaje de la partida.
	 * @return score.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Devuelve si la partida fue ganada o no.
	 * @return won.
	 */
	public boolean isWon() {
		return won;
	}

	/**
	 * Devuelve el timpo de juego de la partida.
	 * @return time.
	 */
	public String getTime() {
		return time;
	}


	/**
	 * Se encarga de recorrer la lista simple hasta hallar el ultimo elemnto de esta(la lista simple), para luego, agregarsela a la siguiente.
	 * @param toAdd Es el elemento a anadir
	 */
	public void addRecord(Record toAdd){
		if (next == null){
			next = toAdd;

		}else {
			next.addRecord(toAdd);
		}
	}

	@Override
	public String toString() {

		String res;
		if (won)
			res = "Si";
		else
			res = "No";

		return
				"Fecha:  '" + date + '\'' +
				"Puntaje:  " + score +
				"Partida Ganada?:  " + won +
				"Tiempo de Juego:  '" + time ;
	}
}



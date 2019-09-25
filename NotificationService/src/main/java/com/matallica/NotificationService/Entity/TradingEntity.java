package com.matallica.NotificationService.Entity;

import java.sql.Date;

import com.metallica.NotificationService.etc.Side;
import com.metallica.NotificationService.etc.TradeStatus;

public class TradingEntity {
	private int id;
	private int quantity; //quantity traded
	private double price; //price at the which the trade was placed/executed
	private Date date; //date of trade
	private String commodity; //item that is being traded
	private String counterParty; //name of counter party of trade
	private String location; //location where trade took place
	private Side side; //buy or sell side
	private TradeStatus status; //open or nominated
	
	
	/****************************CONSTRUCTORS*********************************/
	/**
	 * Default constructor
	 */
	public TradingEntity() {
		super();
	}
	
	/**
	 * @param id
	 * @param quantity: quantity traded
	 * @param price: price at the which the trade was placed/executed
	 * @param date: date of trade
	 * @param commodity: item that is being traded
	 * @param counterParty: name of counter party of trade
	 * @param location: location where trade took place
	 * @param side: buy or sell side
	 * @param status: open or nominated
	 */
	public TradingEntity(int id, int quantity, double price, Date date, 
			String commodity, String counterParty,
			String location, Side side, TradeStatus status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.commodity = commodity;
		this.counterParty = counterParty;
		this.location = location;
		this.side = side;
		this.status = status;
	}
	
	/******************************GETTERS************************************/
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @return the commodity
	 */
	public String getCommodity() {
		return commodity;
	}
	/**
	 * @return the counterParty
	 */
	public String getCounterParty() {
		return counterParty;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @return the side
	 */
	public Side getSide() {
		return side;
	}
	/**
	 * @return the status
	 */
	public TradeStatus getStatus() {
		return status;
	}
	
	
	/*******************************SETTERS***********************************/
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	/**
	 * @param counterParty the counterParty to set
	 */
	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @param side the side to set
	 */
	public void setSide(Side side) {
		this.side = side;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	
	/*******************************METHODS***********************************/
	@Override
	public String toString() {
		return "TradingEntity [id=" + id + ", quantity=" + quantity + 
				", price=" + price + ", date=" + date + ", commodity=" + 
				commodity + ", counterParty=" + counterParty + ", location=" +
				location + ", side=" + side + ", status=" + status + "]";
	}
	
}

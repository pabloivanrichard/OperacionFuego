package com.example.easynotes.service;

import java.util.ArrayList;

import com.example.easynotes.exception.MessageExceptions;

public interface IMessageService {

	public String getMessages(ArrayList<ArrayList<String>> menssages) throws MessageExceptions;

	public ArrayList<String> MsgIndividual(ArrayList<ArrayList<String>> menssages);

	public boolean validateSize(ArrayList<String> individualmessage);

}

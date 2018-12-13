package issue1964.main;

import issue1964.implementations.MessageHandlerImp;
import issue1964.implementations.MessageImp;
import issue1964.interfaces.Message;
import issue1964.interfaces.MessageHandler;

public class MainIssue1964 {
	
	@SuppressWarnings("unused")
	public <REQ extends Message, REP extends Message> void registerMessage(Class<? extends MessageHandler<REQ, REP>> messageHandler, Class<REQ> requestMessageType) {
		
	}
	
	public void chokes() {
		registerMessage(MessageHandlerImp.class, MessageImp.class);
	}
	
	public void chokes2() {
		Class<MessageHandlerImp> a = MessageHandlerImp.class;
		Class<MessageImp> b = MessageImp.class;
		
		registerMessage(a, b);
	}
	
}

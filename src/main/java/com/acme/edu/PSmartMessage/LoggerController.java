package com.acme.edu.PSmartMessage;

import com.acme.edu.Logger;
import com.acme.edu.PController.interfaces.ByteAcc;
import com.acme.edu.PController.interfaces.ConsoleSaver;
import com.acme.edu.PController.interfaces.IntAcc;
import com.acme.edu.PController.interfaces.StringAcc;
import com.acme.edu.PController.interfaces.accumulate.LoggerAccumulate;
import com.acme.edu.PController.interfaces.format.LoggerFormat;
import com.acme.edu.PController.interfaces.save.LoggerSaver;
import com.acme.edu.PSmartMessage.Typemessage.ByteMessage;
import com.acme.edu.PSmartMessage.Typemessage.IntMessage;
import com.acme.edu.PSmartMessage.Typemessage.StringMessage;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

import java.util.ArrayList;

public abstract class LoggerController {

    public String log;
    public LoggerSaver saver;
    public int classmode;
    public static long sum;
    public Message oldMsg;

    public LoggerController()
    {
        log ="";
        classmode = 0;
        sum = 0;
        oldMsg=null;

    }

    public void SetOldMessage(Message old)
    {
        oldMsg=old;
    }

    public void loggingProcess(Message msg)
    {
        msg.setM(oldMsg);
        String tmp = msg.iteration(classmode);
        if(!tmp.equals("")) {
            log += tmp + "\n";
            msg.clearM();
            SetOldMessage(msg);
        }else {
            msg.clearM();
            SetOldMessage(msg);
        }
        changemode(msg);

    }

    private void changemode(Message msg) {
        if(msg instanceof ByteMessage)
        {
            classmode= 1;
            return;
        }
        if(msg instanceof IntMessage)
        {
            classmode = 2;
            return;
        }
        if(msg instanceof StringMessage)
        {
            classmode = 3;
            return;
        }
    }

    public void close()
    {
        if(oldMsg instanceof ByteMessage || oldMsg instanceof IntMessage)
        {
            log+=oldMsg.getSum()+"\n";
        }else if(oldMsg instanceof StringMessage)
        {
            log+= ((StringMessage) oldMsg).getStr() + " (x"+oldMsg.getSum()+")\n";
        }

        saver = new ConsoleSaver(log);
        saver.save();
    }
    public abstract void encode(String log);

}
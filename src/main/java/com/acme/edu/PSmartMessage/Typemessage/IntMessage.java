package com.acme.edu.PSmartMessage.Typemessage;

import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class IntMessage extends Message {
    public int delta;
    public IntMessage(int i) {
        super();
        delta = i;
    }

    public int getDelta() {
        return delta;
    }

    @Override
    public String iteration(int classmode) throws OutofIntegerBoundException {

        switch(classmode)
        {
            case 0:
            {
                sum = delta;
                break;
            }
            case 1:
            {
                if(((ByteMessage)m).getDelta() == Byte.MAX_VALUE |
                        ((ByteMessage)m).getDelta() == Byte.MIN_VALUE)
                {
                    if(getDelta() == Integer.MAX_VALUE |
                            getDelta() == Integer.MIN_VALUE)
                    {
                        sum = 0;
                        return ""+getDelta();
                    }else {
                        sum = delta;
                        return "";
                    }
                }
                else
                {
                    if(getDelta() == Integer.MAX_VALUE |
                            getDelta() == Integer.MIN_VALUE)
                    {
                        sum = 0;
                        return ""+m.sum +"\n"+getDelta();
                    }else {
                        String result = "" + m.sum;
                        sum = delta;
                        return result;
                    }
                }
            }
            case 2:
            {
                if(getDelta() == Integer.MAX_VALUE |
                        getDelta() == Integer.MIN_VALUE) {
                    if (((IntMessage) m).getDelta() == Integer.MAX_VALUE |
                            ((IntMessage) m).getDelta() == Integer.MIN_VALUE) {
                        sum = 0;
                        return "" + delta;
                    } else {
                        sum = 0;
                        return "" + m.sum + "\n" + delta;
                    }
                }
                else {
                    if((int)delta + m.sum>Byte.MAX_VALUE | (int)delta + m.sum<Byte.MIN_VALUE)
                        throw new OutofIntegerBoundException("OUT OF BYTE BOUND!!!");
                    else
                        sum = delta + m.sum;
                    break;
                }
            }
            case 3:
            {
                if(getDelta() == Integer.MAX_VALUE |
                        getDelta() == Integer.MIN_VALUE) {
                    if(m.sum>1)
                        return ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    else
                        return ((StringMessage) m).getStr();
                }
                else {
                    String result;
                    if(m.sum>1)
                        result = ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    else
                        result = ((StringMessage) m).getStr();
                    //((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    sum = delta;
                    return result;
                }

            }
        }
        return "";
    }
}

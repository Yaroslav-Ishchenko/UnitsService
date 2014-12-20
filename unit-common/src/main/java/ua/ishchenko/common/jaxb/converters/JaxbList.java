package ua.ishchenko.common.jaxb.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Jaros on 12/7/2014.
 */
@XmlRootElement(name="List")
public class JaxbList<T>{
    protected List<T> list;

    public JaxbList(){}

    public JaxbList(List<T> list){
        this.list=list;
    }

    @XmlElement(name="Item")
    public List<T> getList(){
        return list;
    }
}

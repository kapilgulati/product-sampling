package org.kapil.product.sampling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public Map<Long, List<ProductSample>> sampleProducts(Collection<ProductSample> newProductSamples, Collection<ProductSample> existingProductSamples){
    	
    	List<ProductSample> _list = new ArrayList<ProductSample>();
    	_list.addAll(existingProductSamples);
    	_list.addAll(newProductSamples);
    	
    	//sorts the data in descending order
    	Collections.sort(_list);
    	
    	Map<Long, List<ProductSample>> _groups = new HashMap<Long, List<ProductSample>>();
    	
    	Date currentSampleDate = null;
    	Long groupId = 0l; 
    	for(ProductSample p : _list){
    		if(currentSampleDate==null || !currentSampleDate.equals(p.getSampleDate())){
    			//seed a new group
    			groupId = groupId +1;
    			_groups.put(groupId, new ArrayList<ProductSample>());
    		}
    		//add the product sample to the group only if applicable
    		if(_groups.get(groupId).size()<=4){
    			_groups.get(groupId).add(p);
    		}else{
    			groupId = groupId +1;
    			_groups.put(groupId, new ArrayList<ProductSample>());
    			_groups.get(groupId).add(p);
    		}
    		currentSampleDate = p.getSampleDate();
    		
    	}
    	
    	return _groups;
    }
}

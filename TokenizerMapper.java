package tn.isima.wiem;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public  class TokenizerMapper
extends Mapper<LongWritable, Text, NullWritable, IntWritable>{
@Override
public void map(LongWritable key, Text value, Context context
             ) throws IOException, InterruptedException {
	String line = value.toString();

	String[] data=line.split(",");
	try {
		
		int nbre_max = Integer.parseInt(data[8]);	
		
		context.write(NullWritable.get(),new IntWritable(nbre_max));
			
	} catch(Exception e ) {
		
	}
	
		
	

}
}
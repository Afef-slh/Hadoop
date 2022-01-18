package tn.isima.wiem;


import java.io.IOException;





import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class NumSumReducer extends Reducer<NullWritable, IntWritable, NullWritable, IntWritable> {

private IntWritable result = new IntWritable();

public void reduce(NullWritable key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
    
	int sum = 0;
    for(IntWritable x : values){
    	sum+= x.get();
        }
	System.out.print("le somme de likes est: "+ sum );
    result.set(sum);
    	
    }
    
@Override
protected void cleanup(Context context) throws IOException, InterruptedException {
	
    context.write(NullWritable.get(), result);
}
}

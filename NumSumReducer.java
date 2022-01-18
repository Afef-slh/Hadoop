package tn.isima.wiem;


import java.io.IOException;





import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class NumSumReducer extends Reducer<NullWritable, IntWritable, NullWritable, IntWritable> {

int sum = 0;

public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
    
	
    for(IntWritable x : values){
    	sum+= x.get();
        }
    sum+=sum;
    	
    }
    
@Override
protected void cleanup(Context context) throws IOException, InterruptedException {
	System.out.print("le somme de likes est: "+ sum );
    context.write(NullWritable.get(), new IntWritable(sum));
}
}
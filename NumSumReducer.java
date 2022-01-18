package tn.isima.wiem;


import java.io.IOException;





import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class NumSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

int max = 0;
Text maxWord = new Text();
public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
    
	int sum =0;
    for(IntWritable x : values){
    	sum+= x.get();
        }
    sum+=sum;
    	maxWord.set(key);
    }
    
@Override
protected void cleanup(Context context) throws IOException, InterruptedException {
	System.out.print("linfluenceur ayant le plus nombre de share est "+maxWord );
    context.write(maxWord, new IntWritable(max));
}
}
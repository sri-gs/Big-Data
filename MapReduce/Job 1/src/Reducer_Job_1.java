
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class Reducer_Job_1 extends Reducer<Text, Text, Text, IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<Text> value,
			Reducer<Text, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		int count=0;
		for(Text i:value){
			if(String.valueOf(i).equals("Critical")){
				count++;
			}
		}
		context.write(key, new IntWritable(count));
	}

}

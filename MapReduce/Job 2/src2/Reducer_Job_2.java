
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class Reducer_Job_2 extends Reducer<Text, FloatWritable, Text, FloatWritable>{

	@Override
	protected void reduce(Text key, Iterable<FloatWritable> value,
			Reducer<Text, FloatWritable, Text, FloatWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		float sum = 0;
		for(FloatWritable i:value){
			sum=sum+Float.parseFloat(i.toString());
		}
		context.write(key, new FloatWritable(sum));
	}

}

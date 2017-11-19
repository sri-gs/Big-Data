import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Mapper_Job_2 extends Mapper<LongWritable, Text, Text, FloatWritable>{

	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, FloatWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(key.get()==0){
			return;
		}
		else{
			String Line = value.toString();
			String[] data=Line.split("\t");
			context.write(new Text(data[12]), new FloatWritable(Float.parseFloat(data[8].trim())));
		}
	}	
}

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Mapper_Job_1 extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String Line = value.toString();
		String data[]=Line.split("\t");
		if(data[15].contains("Technology")){
			context.write(new Text(data[15]), new Text(data[3]));
		}
	}
	
	
}

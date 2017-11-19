import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/*
 * JOB 2 - To find the profits earned in each Province
 */

public class Driver_Job_2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Job job=new Job();
		job.setJobName("Profits in Each Province");
		job.setJarByClass(Driver_Job_2.class);
		job.setMapperClass(Mapper_Job_2.class);
		job.setReducerClass(Reducer_Job_2.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FloatWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		
		System.exit(job.waitForCompletion(true)?0:1);

	}

}

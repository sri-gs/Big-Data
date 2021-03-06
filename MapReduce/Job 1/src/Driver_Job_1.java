import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/*
 * JOB 1 - To find the number of jobs with Order Priority as "Critical" in Product Category "Technology"
 */

public class Driver_Job_1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Job job=new Job();
		job.setJobName("Critical Order Priority");
		job.setJarByClass(Driver_Job_1.class);
		job.setMapperClass(Mapper_Job_1.class);
		job.setReducerClass(Reducer_Job_1.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		
		System.exit(job.waitForCompletion(true)?0:1);

	}

}

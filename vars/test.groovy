

import java.string.*

repo = 'https://github.com/BobbyShaftoe/server-bootstraps-ansible.git'
//repoName = repo.replace('http.*/([a-zA-Z0-9_-]+)\\.git', 'zzz')
repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')

println repoName

sh "echo $repoName"

// Placeholder
//withEnv(['JRE_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.161-0.b14.amzn2.x86_64/jre']) {
    // some block
//}




// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
// 
// public class RegexMatches {
//     public static void main(String args[]) {
// 
//         // String to be scanned to find the pattern.
//         String line = "This order was placed for QT3000! OK?";
//         String pattern = "(.*)(\\d+)(.*)";
// 
//         // Create a Pattern object
//         Pattern r = Pattern.compile(pattern);
// 
//         // Now create matcher object.
//         Matcher m = r.matcher(line);
//         if (m.find()) {
//             System.out.println("Found value: " + m.group(0));
//             System.out.println("Found value: " + m.group(1));
//             System.out.println("Found value: " + m.group(2));
//         } else {
//             System.out.println("NO MATCH");
//         }
//     }
// }
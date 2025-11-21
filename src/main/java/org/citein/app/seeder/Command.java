package org.citein.app.seeder;

public class Command {
    
    public static final Long NULL = 0L;
    
    public static <T> boolean checkSeeder(Class<T> clazz, int pos, String ...args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                if (i != pos || (arg == null || arg.strip().isEmpty())) {
                    continue;
                }

                if (arg.startsWith("--class[" + pos + "]=")) {
                    String[] nameClassArgs = arg.replaceAll("--class\\[" + pos +"\\]=", "")
                            .split(",");
                    
                    for (String className : nameClassArgs) {
                        if (clazz.getSimpleName().equals(className)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

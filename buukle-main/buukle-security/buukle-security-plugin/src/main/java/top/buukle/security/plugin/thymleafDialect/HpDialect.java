package top.buukle.security.plugin.thymleafDialect;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class HpDialect extends AbstractProcessorDialect implements IProcessorDialect {
 
	private static final String PREFIX = "hp";
 
	public HpDialect() {
        super("permission_dialect", PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
	}
 
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		Set<IProcessor> processors = new HashSet<>();
		processors.add(new HpProcessor(PREFIX));
		return processors;
	}
 
}
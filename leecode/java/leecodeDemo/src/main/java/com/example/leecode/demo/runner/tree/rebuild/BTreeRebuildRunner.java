package com.example.leecode.demo.runner.tree.rebuild;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "treeBuild")
public class BTreeRebuildRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}

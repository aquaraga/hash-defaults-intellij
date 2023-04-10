package com.thoughtworks.hashdefaults.inpsections;

import com.intellij.codeInspection.*;
import com.intellij.psi.*;
import com.thoughtworks.hashdefaults.fixes.MyCustomQuickFix;
import org.jetbrains.annotations.NotNull;

public class MyCustomInspection extends LocalInspectionTool {
    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new PsiElementVisitor() {
            @Override
            public void visitFile(@NotNull PsiFile file) {
                if (isPackageJsonWithTestingLibraryReact(file)) {
                    ProblemDescriptor descriptor = holder.getManager().createProblemDescriptor(
                            file,
                            "Testing Library React",
                            new MyCustomQuickFix(),
                            ProblemHighlightType.INFORMATION,
                            isOnTheFly
                    );
                    holder.registerProblem(descriptor);
                }
            }
        };
    }

    private boolean isPackageJsonWithTestingLibraryReact(PsiFile file) {

        //Check if the file is a package.json
        if (file.getName().equals("package.json")) {
            //Check if the file contains a dependency on testing-library/react
            return file.getText().contains("testing-library/react");
        }
        return false;
    }
}
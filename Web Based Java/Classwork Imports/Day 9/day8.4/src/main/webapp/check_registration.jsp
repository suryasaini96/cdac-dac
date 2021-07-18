<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:setProperty property="*" name="candidate" />

<c:redirect url="${sessionScope.candidate.registerCandidate()}.jsp" />

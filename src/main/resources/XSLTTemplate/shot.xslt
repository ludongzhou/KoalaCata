<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <xsl:for-each select="MetaData.Shot">
                <Shot>
                    <Title>
                        <ShotTitle>
                            <xsl:value-of select="MetaData.Shot.Title.ShotTitle"/>
                        </ShotTitle>
                    </Title>
                    <Subject>
                        <xsl:for-each select="MetaData.Shot.Subject.SubjectTerm">
                            <SubjectTerm>
                                <xsl:value-of select="current()"/>
                            </SubjectTerm>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Shot.Subject.Keyword">
                            <Keyword>
                                <xsl:value-of select="current()"/>
                            </Keyword>
                        </xsl:for-each>
                    </Subject>
                    <Description>
                        <DescriptionofContent>
                            <xsl:value-of select="MetaData.Shot.Description.DescriptionofContent"/>
                        </DescriptionofContent>
                        <ShootingPlace>
                            <xsl:value-of select="MetaData.Shot.Description.ShootingPlace"/>
                        </ShootingPlace>
                        <xsl:for-each select="MetaData.Shot.Description.CameraMotion">
                            <CameraMotion>
                                <xsl:value-of select="current()"/>
                            </CameraMotion>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Shot.Description.CameraMotion">
                            <CameraMotion>
                                <xsl:value-of select="current()"/>
                            </CameraMotion>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Shot.Description.CameraMotion">
                            <CameraMotion>
                                <xsl:value-of select="current()"/>
                            </CameraMotion>
                        </xsl:for-each>
                        <NaturalSound>
                            <xsl:value-of select="MetaData.Shot.Description.NaturalSound"/>
                        </NaturalSound>
                    </Description>
                    <Date>
                        <xsl:value-of select="MetaData.Shot.Date"/>
                    </Date>
                    <Format>
                        <Duration>
                            <xsl:value-of select="MetaData.Shot.Format.Duration"/>
                        </Duration>
                        <StartingPoint>
                            <xsl:value-of select="MetaData.Shot.Format.StartingPoint"/>
                        </StartingPoint>
                    </Format>
                </Shot>
            </xsl:for-each>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>